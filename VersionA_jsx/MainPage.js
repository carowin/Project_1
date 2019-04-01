import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import marbleEstompe from './css/marbleEstompe.jpeg';
import search from './css/search.png';
import './bootstrap/css/bootstrap.min.css';
import NavigationPanel from './NavigationPanel.js';
import ContentPanel from './ContentPanel.js';

class Mainpage extends Component {
  constructor(props){
      super(props);
  }

  render(){
    return (
      <NavigationPanel />;
      <ContentPanel />;
    );
  }

}

export default MainPage;
