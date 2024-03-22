import { Grid, Stack } from '@mui/material'
import Button from '@mui/material/Button'
import * as React from 'react'
import { useGetMessage, usePostMessage } from '../../hooks/api/useMessage'

const Component = () => {
  const message = useGetMessage()
  const messagePostParam = {
    title: 'sample'
  }

  const postResult = usePostMessage(messagePostParam)

  return (
    <div>
      {message.isError ? <h1>ERROR!</h1> : <h1>SUCCESS!</h1>}
      <h2>{message.error?.message}</h2>
      {/* <h2>{message.data?.naiyou}</h2> */}
      <h2>{postResult.data?.result}</h2>
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
