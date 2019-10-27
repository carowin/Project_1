import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import axios from 'axios';
import {cookie} from './MainPage';

class MyPostPanel extends Component {
  constructor(props){
    super(props);
    this.state = { message:'' };

    this.postMyMessage = this.postMyMessage.bind(this);
  }

  postMyMessage(){
    var formData = new URLSearchParams();
    formData.append("key", cookie.get("mykey"));
    formData.append("content", this.state.message);
    console.log(this.state.message);
    axios.get('http://localhost:8080/Twister/Servlets/AddComment?'+formData)
    .catch(r => {alert("ERROR")});
    console.log("posted");
  }

  render(){
    return (
      <div className="post">
        <input
          type="text"
          name="post"
          id="post"
          placeholder=" What's on your mind ?"
          value={ this.state.message }
          onChange={(e) => {this.setState({message: e.target.value})}}
        />
        <input
          onClick = {this.postMyMessage.bind(this)}
          type="submit"
          name="submit"
          id="submit"
          value="ENTER" /><br />
      </div>
    );
  }
}

export default MyPostPanel;
