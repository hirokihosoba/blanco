import { QueryClient, useQuery } from '@tanstack/react-query'
import axios from 'axios'
import * as qs from 'qs'
import { useMessage } from './useMessage';

export type apiErrorInfo = {
  status?: number
  code?: string
  message?: string
}

// eslint-disable-next-line prefer-const
let defaultApiErrorInfo: apiErrorInfo = {
  status: 404,
  code: 'E001',
  message: 'Cannnot fetch api response'
}

export const defaultQueryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: false,
      retryOnMount: true
    },
    mutations: {
      retry: false
    }
  }
})

const csrfToken = document.cookie.split('; ').find((value) => value === 'XSRF-TOKEN')

const getHeaders = {
  'Content-Type': 'application/json'
}

const paramsSerializer = (params: any) => qs.stringify(params)

export const useGetApi = <T, R>(url: string, params: R) =>
  useQuery<T>({
    queryKey: [url],
    queryFn: async () =>
      axios
        .get<T>('/api/' + url, { headers: getHeaders, params, paramsSerializer })
        .then((res) => res.data)
        .catch((error) => errorHandler(error))
  })

const postHeaders = {
  'Content-Type': 'application/json',
  'X-XSRF-TOKEN': csrfToken
}

export const usePostApi = <T, R>(url: string, params: R) =>
  useQuery<T>({
    queryKey: [url],
    queryFn: async () =>
      axios
        .post<T>('/api/' + url, params, { headers: postHeaders })
        .then((res) => res.data)
        .catch((error) => errorHandler(error))
  })

const errorHandler = (error: any) => {
  if (!error.response.data) {
    defaultApiErrorInfo.status = error.response.status
    error.response.data = {
      apiErrorInfo: defaultApiErrorInfo
    }
  }
  return error.response.data
}

export const useApi = () => {
  const { setMessages } = useMessage();

  const fetchMessages = async () => {
    try {
      const response = await axios.get('/api/messages');
      setMessages(response.data);
    } catch (error) {
      console.error('Error fetching messages:', error);
    }
  };

  const postMessage = async (message: string) => {
    try {
      await axios.post('/api/messages', { message });
    } catch (error) {
      console.error('Error posting message:', error);
    }
  };

  return {
    fetchMessages,
    postMessage,
  };
};