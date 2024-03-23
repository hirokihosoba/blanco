import { apiErrorInfo, useGetApi, usePostApi } from './useApi'

export type messageResponseType = {
  apiErrorInfo?: apiErrorInfo
  naiyou: number[]
  result1: string
  result2: string
}

export type messagePostRequestType = {
  title: string
}

export type getExceptionType = {
  apiErrorInfo?: apiErrorInfo
  title: string
}

export type paramRequestType = {
  param1: string
  param2: string
}

export type messagePostResponseType = {
  apiErrorInfo?: apiErrorInfo
  result: string
}

export const useGetMessage = () => {
  return useGetApi<messageResponseType, null>('test', null)
}

export const useGetError = () => {
  return useGetApi<getExceptionType, null>('error', null)
}

export const useGetParam = () => {
  const params: paramRequestType = {
    param1: 'リクエスト',
    param2: 'Success'
  }
  return useGetApi<messageResponseType, paramRequestType>('param', params)
}

export const usePostMessage = (param: messagePostRequestType) => {
  return usePostApi<messagePostResponseType, messagePostRequestType>('post', param)
}
