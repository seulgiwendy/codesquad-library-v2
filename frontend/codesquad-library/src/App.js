import React, { Component } from 'react';
import {BrowserRouter} from 'react-router-dom'
import MainComponent from './main/MainComponent';
import Router from './Router';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Router/>
      </BrowserRouter>
    );
  }
}

export default App;
