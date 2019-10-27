import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/MainPage.css';
import MyPostPanel from './MyPostPanel.js';
import MessagePanel from './MessagePanel.js';
import axios from 'axios';
import {cookie} from './MainPage';

class MenuPage extends Component {
  constructor(props){
    super(props);
  }

  render(){
    let postPanel = <MyPostPanel />;
    let messagePanel = <MessagePanel
                          whoProfil={this.props.whoProfil}
                          currentId={this.props.currentId}
                          setCurrendId={this.props.setCurrendId}
                          pageCourante={this.props.pageCourante}
                          getMessage={this.props.getMessage}
                       />;           
    return (
      <div className="body">
        <div className="row two">
          <div className="col-md-2 right"><p> </p></div>
          <div className="col-md-8 center">
            {postPanel}
            {messagePanel}
          </div>
          <div className="col-md-2 left"><p> </p></div>
        </div>
      </div>
    );
  }
}

export default MenuPage;
