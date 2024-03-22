import { useGetApi, usePostApi } from './useApi'

// interface baseResponse {
//   errorMessage?: string
// }

export type messageResponseType = {
  naiyou: number[]
}

export type messagePostResponseType = {
  result: string
}

export const useGetMessage = () => {
  return useGetApi<messageResponseType>('test')
}

export const usePostMessage = (param: any) => {
  return usePostApi<messagePostResponseType>('post', param)
}
