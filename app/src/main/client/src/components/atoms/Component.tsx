import { Grid, Stack } from '@mui/material'
import Button from '@mui/material/Button'
import * as React from 'react'
import { messagePostRequestType, useGetError, usePostMessage } from '../../hooks/api/useMessage'

const Component = () => {
  // const message = useGetMessage()
  // const paramQuery = useGetParam()
  const messagePostParam: messagePostRequestType = {
    title: 'sample'
  }
  const errorQuery = useGetError()

  const postQuery = usePostMessage(messagePostParam)

  return (
    <div>
      <h2>STATUS: {errorQuery.data?.apiErrorInfo?.status}</h2>
      <h2>MESSAGE: {errorQuery.data?.apiErrorInfo?.message}</h2>

      <h2>POST ERROR STUTUS: {postQuery.data?.apiErrorInfo?.status}</h2>
      <h2>POST ERROR MESSAGE: {postQuery.data?.apiErrorInfo?.message}</h2>
      <Grid container justifyContent="center">
        <Stack direction="column">
          <Button variant="text">Hello World</Button>
          <Button variant="contained">Hello World</Button>
          <Button variant="outlined">Hello World</Button>
        </Stack>
      </Grid>
    </div>
  )
}

export default Component
