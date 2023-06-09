import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { apiHello } from './services/server';

function App() {

  const [backendMessage, setBackendMessage] = useState<string>("");

  const clickHandler = (e: React.MouseEvent<HTMLButtonElement>) => {
    let msg:string = "";
    apiHello()
      .then(response => {
        setBackendMessage(response.data);
      })
      .catch(error => {
        setBackendMessage(JSON.stringify(error));
      })
  }

  return (
    <div className="App">
      <button onClick={clickHandler}>Hello!</button>
      <span>{backendMessage}</span>
    </div>
  );
}

export default App;
