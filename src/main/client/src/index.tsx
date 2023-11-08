import Component from './Component';
import * as React from 'react';
import { createRoot } from 'react-dom/client';

const app = createRoot(document.getElementById('app') as Element);
app.render(<Component/>);