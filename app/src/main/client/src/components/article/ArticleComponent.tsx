import * as React from 'react'
import { useState, useEffect, FormEvent } from 'react';
import { TextField, Button, Container, Typography } from '@mui/material';
import { styled } from '@mui/system';
import { useMessage } from '../../hooks/api/useMessage';
import { useApi } from '../../hooks/api/useApi';

const StyledContainer = styled(Container)({
  maxWidth: 400,
  margin: '100px auto',
  padding: 20,
  backgroundColor: '#fff',
  borderRadius: 8,
  boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
});

const InputGroup = styled('div')({
  marginBottom: 20,
});

const StyledButton = styled(Button)({
  display: 'block',
  width: '100%',
  padding: 10,
  color: '#fff',
  backgroundColor: '#007bff',
  border: 'none',
  borderRadius: 4,
  cursor: 'pointer',
  transition: 'background-color 0.3s ease',
  '&:hover': {
    backgroundColor: '#0056b3',
  },
});

const ArticleComponent: React.FC = () => {
  const [message, setMessage] = useState<string>('');
  const { messages, addMessage } = useMessage();
  const { fetchMessages, postMessage } = useApi();

  useEffect(() => {
    fetchMessages();
  }, [fetchMessages]);

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    try {
      await postMessage(message);
      addMessage(message);
      setMessage('');
    } catch (error) {
      console.error('Error posting message:', error);
    }
  };

  return (
    <StyledContainer>
      <Typography variant="h4" component="h1">
        Post a Message
      </Typography>
      <form onSubmit={handleSubmit}>
        <InputGroup>
          <TextField
            label="Message"
            variant="outlined"
            fullWidth
            value={message}
            onChange={(e) => setMessage(e.target.value)}
          />
        </InputGroup>
        <StyledButton type="submit">
          Post
        </StyledButton>
      </form>
      <div>
        {messages.map((msg, index) => (
          <Typography key={index} variant="body1">
            {msg}
          </Typography>
        ))}
      </div>
    </StyledContainer>
  );
};

export default ArticleComponent;