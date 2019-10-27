import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import axios from 'axios';
import {cookie} from './MainPage';

class MessagePanel extends Component {
  constructor(props){
    super(props);
    this.state = {listMessage: []};
  }


  /*getMessage(id){
      var self = this;
      var formData = new URLSearchParams();
      if(id === -1){
        formData.append('key', cookie.get("mykey"));
      }else{
        formData.append('key', null);
      }
      formData.append('id_users', id);
      console.log('http://localhost:8080/Twister/Servlets/ListMessage?'+formData);
      axios.get('http://localhost:8080/Twister/Servlets/ListMessage?'+formData)
        .then (response => {
          self.setState({listMessage: response.data.Messages});
          console.log(response.data.Messages);
        })
    }*/

    componentDidMount(){
        var self = this;
        var formData = new URLSearchParams();
        if(this.props.currentId === -1){
          formData.append('key', cookie.get("mykey"));
        }else{
          formData.append('key', null);
        }
        formData.append('id_users', this.props.currentId);
        console.log('http://localhost:8080/Twister/Servlets/ListMessage?'+formData);
        axios.get('http://localhost:8080/Twister/Servlets/ListMessage?'+formData)
          .then (response => {
            self.setState({listMessage: response.data.Messages});
          })
      }

  render(){
    /*if(this.props.pageCourante === 'mur de tweet'){
      //this.getMessage(-1);
    }else{
      this.getMessage(this.props.currentId);
    }*/
    if(this.props.pageCourante === 'private message'){
      return
    }else{
      return (
        <div className="myPosts">
          {this.state.listMessage.map((key) =>
            <div className="onePost">
              <p>{key.login} {console.log(key)}</p>
              <span className="text">{key.text} </span>
                <br></br>
            </div>
          )}
        </div>
      );
    }
  }
}

export default MessagePanel;
