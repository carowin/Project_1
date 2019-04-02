import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/Welcome.css';
import MainPage from './MainPage.js';

class WelcomeForm extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div>
        <div className="row welcome">
          <div className="col-md-7">
            <h1>HI ! </h1>
            <h1>WELCOME TO TWISTER ! </h1>>
          </div>

          <div className="col-md-5">
            <img className="img" src={marble}/>
          </div>
        </div>
      </div>
    );
  }
}

export default WelcomeForm;
