import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import * as React from 'react'
import { createRoot } from 'react-dom/client'
import ArticleComponent from '../../components/article/ArticleComponent'

const article = createRoot(document.getElementById('article') as Element)
const queryClient = new QueryClient()

article.render(
  <QueryClientProvider client={queryClient}>
    <ArticleComponent />
  </QueryClientProvider>
)
