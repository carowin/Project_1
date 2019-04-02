import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/MainPage.css';

class MenuPage extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return (
      <div className="body">
        <div className="row two">
          <div className="col-md-2 right"><p> </p></div>
          <div className="col-md-8 center">
            <span> HELLO ! HOW ARE YOU DOING ?</span>
            <div className="post">
              <label for="post" ></label>
              <input type="text" name="post" id="post" /><br />
            </div>

            <div className="enter">
              <label for="submit"></label>
              <input type="submit" name="submit" id="submit" value="Enter" /><br />
            </div>
          </div>
          <div className="col-md-2 left"><p> </p></div>
        </div>
      </div>
    );
  }
}

export default MenuPage;
