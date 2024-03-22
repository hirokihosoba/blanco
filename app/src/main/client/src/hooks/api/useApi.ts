import { QueryClient, useQuery } from '@tanstack/react-query'
import axios from 'axios'
import * as qs from 'qs'

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
        .catch((error) => error.response.data)
  })

const postHeaders = {
  'Content-Type': 'application/json',
  'X-XSRF-TOKEN': csrfToken
}

export const usePostApi = <T, R>(url: string, params: R) =>
  useQuery<T>({
    queryKey: [url],
    queryFn: async () => axios.post<T>('/api/' + url, params, { headers: postHeaders }).then((res) => res.data)
  })
