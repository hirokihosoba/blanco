import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import * as React from 'react'
import { createRoot } from 'react-dom/client'
import Component from '../../components/atoms/Component'

const app = createRoot(document.getElementById('app') as Element)
const queryClient = new QueryClient()

app.render(
  <QueryClientProvider client={queryClient}>
    <Component />
  </QueryClientProvider>
)
