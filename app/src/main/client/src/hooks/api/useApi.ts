import { QueryClient, useQuery } from '@tanstack/react-query'
import axios from 'axios'

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

const cookieValue = document.cookie.split('; ').find((value) => value === 'XSRF-TOKEN')

const headers = {
  'Content-Type': 'application/json',
  'X-XSRF-TOKEN': cookieValue
}

export const useGetApi = <T>(url: string) =>
  useQuery<T>({
    queryKey: [url],
    queryFn: async () => axios.get<T>('/api/' + url).then((res) => res.data)
  })

export const usePostApi = <T>(url: string, params: any) =>
  useQuery<T>({
    queryKey: [url],
    queryFn: async () => axios.post<T>('/api/' + url, params, { headers: headers }).then((res) => res.data)
  })
