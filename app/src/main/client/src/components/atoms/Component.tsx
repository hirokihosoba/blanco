import { Grid, Stack } from '@mui/material'
import Button from '@mui/material/Button'
import * as React from 'react'
import { useGetError } from '../../hooks/api/useMessage'

const Component = () => {
  // const message = useGetMessage()
  // const paramQuery = useGetParam()
  // const messagePostParam: messagePostRequestType = {
  //   title: 'sample'
  // }
  const errorQuery = useGetError()

  // const postResult = usePostMessage(messagePostParam)

  return (
    <div>
      <h2>{errorQuery.isError}</h2>
      <h2>{!errorQuery.isError}</h2>
      <h2>{errorQuery.data?.apiErrorInfo?.message}</h2>
      {/* {message.isError ? <h1>ERROR!</h1> : <h1>SUCCESS!</h1>} */}
      {/* <h2>{message.error?.message}</h2>
      <h2>{message.error?.message}</h2>
      <h2>{paramQuery.data?.result1}</h2>
      <h2>{paramQuery.data?.result2}</h2>
      <h2>{message.error?.message}</h2> */}
      {/* <h2>{message.data?.naiyou}</h2> */}
      {/* <h2>{postResult.data?.result}</h2> */}
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
