import React, { Component } from 'react';
import mario from './css/mario.jpg';
import './bootstrap/css/bootstrap.min.css';
import './css/Profil.css';
import {cookie} from './MainPage';
import axios from 'axios';
import MyPostPanel from './MyPostPanel.js';
import MessagePanel from './MessagePanel.js';

class ProfilPage extends Component {
  constructor(props){
    super(props);

    this.handleFriend = this.handleFriend.bind(this);
    this.addFriend = this.addFriend.bind(this);
  }

  handleFriend(){
    this.props.getMyListFriend();
    this.props.setFriend();
  }

  addFriend(name){
    var formData = new URLSearchParams();
    formData.append('key', cookie.get("mykey"));
    formData.append('loginFriend', name);
    console.log(name);
    axios.get('http://localhost:8080/Twister/Servlets/AddFriend?'+formData)
    .then (r => {
      this.props.profil();
    })
    .catch(r => { alert("Erreur adding friend"); });
  }


  render(){
    let postPanel = <MyPostPanel />;
    let messagePanel = <MessagePanel
                          whoProfil={this.props.whoProfil}
                          currentId={this.props.currentId}
                          setCurrendId={this.props.setCurrendId}
                          pageCourante={this.props.pageCourante}
                          listMessage={this.props.listMessage}
                          getMessage={this.props.getMessage}
                        />;
    if(this.props.whoProfil === 'me'){
      return(
        <div>
          <div className="row two">
            <div className="col-md-2 right"><p> </p></div>

            <div className="col-md-8 center">
                <div className="info">
                  <img className="img" src={mario}/>
                  <div className="myInfo">
                    <h1> {cookie.get("mylog")}</h1>
                    <input
                      className="friends"
                      type="button"
                      name="friends"
                      id="friends"
                      value="MY FRIENDS"
                      onClick = {this.handleFriend.bind(this)}
                    />
                  </div>
                </div>
                {postPanel}
                {messagePanel}
              </div>

              <div className="col-md-2 left"><p> </p></div>
          </div>
        </div>
      );
    }else{
      return (
        <div>
          <div className="row two">
            <div className="col-md-2 right"><p> </p></div>

            <div className="col-md-8 center">
                <div className="info">
                  <img className="img" src={mario}/>
                  <div className="myInfo">
                    <h1> {this.props.whoProfil}</h1>
                  </div>
                </div>
                {messagePanel}
              </div>

              <div className="col-md-2 left"><p> </p></div>
          </div>
        </div>
      );
    }
  }
}

export default ProfilPage;
