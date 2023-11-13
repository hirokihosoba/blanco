import * as React from 'react';
import { createRoot } from 'react-dom/client';
import Component from '../../components/atoms/Component';


const app = createRoot(document.getElementById('app') as Element);
app.render(<Component/>);
