import { Grid, Stack } from '@mui/material'
import Button from '@mui/material/Button'
import axios from 'axios'
import * as React from 'react'
import { useEffect, useState } from 'react'

type Message = {
  content: string
}

const initalMessage: Message = {
  content: ''
}

const Component = () => {
  const [message, setMessages] = useState<Message>(initalMessage)

  const getMessage = async () => {
    try {
      // URL
      const url = 'http://localhost:8080/api/test'

      const response = await axios.get<Message>(url)
      console.log(response)
      return response.data
    } catch (error) {
      console.error(error)
      return initalMessage
    }
  }

  useEffect(() => {
    ;(async () => {
      const response = await getMessage()
      setMessages(response)
    })()
  }, [])

  return (
    <div>
      <h2>{message.content}</h2>
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
