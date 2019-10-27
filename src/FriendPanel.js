import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/Friends.css';
import axios from 'axios';
import {cookie} from './MainPage';

class FriendPanel extends Component {
  constructor(props){
    super(props);

    this.deleteFriend = this.deleteFriend.bind(this);
    this.goToFriendProfil = this.goToFriendProfil.bind(this);
    this.getId = this.getId.bind(this);
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
    .catch(r => { alert("Erreur addFriend"); });
  }

  deleteFriend(name){
    var formData = new URLSearchParams();
    formData.append('key', cookie.get("mykey"));
    formData.append('loginFriend', name);
    console.log(name);
    axios.get('http://localhost:8080/Twister/Servlets/RemoveFriend?'+formData)
    .then (r => {
      this.props.profil();
    })
    .catch(r => { alert("Erreur deletefriend"); });
  }

  getId(){
    var self =this;
    var formData = new URLSearchParams();
    formData.append('login', this.props.whoProfil);
    console.log('http://localhost:8080/Twister/Servlets/GetId?'+formData);
    axios.get('http://localhost:8080/Twister/Servlets/GetId?'+formData)
    .then (r => {
      console.log(r.data.id);
      this.props.setCurrendId(cookie.get("myid"));
      //self.props.setCurrendId(r.data.id);
    })
    .catch(r => { alert("Erreur adding friend"); });
  }

  goToFriendProfil(name){
    this.props.setWhoProfil(name);

    this.props.profil();
    this.getId();
    console.log(this.props.whoProfil);
  }

  render(){
    {console.log(this.props.searchBar);}
    if(this.props.searchBar === 'true'){
      return (
        <div className="row two">
          <div className="col-md-2 left"><p> </p></div>

          <div className="col-md-8 center">
            <div className="myFriends">
              {this.props.listFriend.map((name) =>
                <div className="friend">
                  <span>{name}</span>
                  <input
                    type="button"
                    className="seeMe"
                    name="friend"
                    id="friend"
                    value="SEE PROFILE"
                    onClick = {
                      () => this.goToFriendProfil(name) }
                  />
                  <input
                    type="button"
                    className="addme"
                    name="addfriend"
                    id="addfriend"
                    value="ADD ME"
                    onClick = {() => this.addFriend(name)}
                  />
                  </div>
              )}
            </div>

          </div>

          <div className="col-md-2 right"><p> </p></div>
        </div>
      );
    }else{
      return (
        <div className="row two">
          <div className="col-md-2 left"><p> </p></div>

          <div className="col-md-8 center">
            <div className="myFriends">
              {this.props.listFriend.map((name) =>
                <div className="friend">
                  <span>{name}</span>
                  <input
                    type="button"
                    className="seeMe"
                    name="friend"
                    id="friend"
                    value="SEE PROFILE"
                    onClick = { () => this.goToFriendProfil(name) }
                  />
                  <input
                    type="button"
                    className="x"
                    name="unfriend"
                    id="unfriend"
                    value="X"
                    onClick = {() => this.deleteFriend(name)}
                  />
                  </div>
              )}
            </div>

          </div>

          <div className="col-md-2 right"><p> </p></div>
        </div>
      );
    }

  }

}

export default FriendPanel;
