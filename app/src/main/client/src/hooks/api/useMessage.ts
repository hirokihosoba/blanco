import { useGetApi, usePostApi } from './useApi'

// interface baseResponse {
//   errorMessage?: string
// }

export type messageResponseType = {
  naiyou: number[]
}

export type messagePostRequestType = {
  title: string
}

export type messagePostResponseType = {
  result: string
}

export const useGetMessage = () => {
  return useGetApi<messageResponseType>('test')
}

export const usePostMessage = (param: messagePostRequestType) => {
  return usePostApi<messagePostResponseType, messagePostRequestType>('post', param)
}
