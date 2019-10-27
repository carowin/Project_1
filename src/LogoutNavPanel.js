import React, { Component } from 'react';
import search from './css/search.png';
import './bootstrap/css/bootstrap.min.css';
import './nP_Logout.css';
import msg from './css/msg.jpeg';
import axios from 'axios';
import {cookie} from './MainPage';

class LogoutNavPanel extends Component {
  constructor(props){
    super(props);
    this.state = {query:''}
    this.changeBar = this.changeBar.bind(this);
    this.handleProfil = this.handleProfil.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
    this.handlePrivateMessage = this.handlePrivateMessage.bind(this);
  }

  changeBar(){
    var formData = new URLSearchParams();
    formData.append("key", cookie.get("mykey"));
    axios.get('http://localhost:8080/Twister/Servlets/Logout?'+formData)
    .then (r => {
      this.props.setConnection(false);
      this.props.setLogout();
    })
    .catch(r => {alert("ERROR")});
  }

  handleProfil(){
    this.props.setSearchBar("false");
    this.props.profil();
    this.props.setWhoProfil('me');
    this.props.setCurrendId(cookie.get("myid"));
  }

  handleSearch(query){
    this.props.setSearchBar("true");
    this.props.getSearchBarFriend(query);
    this.props.setFriend();
  }

  handlePrivateMessage(){
    this.props.setPrivateMessage();
  }

  render(){
    return(
      <div className="row one">
        <div className="col-md-2 right"><p> </p></div>
        <div className="col-md-2 logo">
          <input onClick={this.props.setWall} type="button" value="TWISTER" />
        </div>
        <div className="col-md-4 search">
          <input
            type="text"
            placeholder="SEARCH ..."
            value={ this.state.query }
            onChange={(e) => {this.setState({query: e.target.value})}}
            />
          <button onClick={() => this.handleSearch(this.state.query)} type="submit">
            <img src={search}/>
          </button>
        </div>

        <div className="col-md-1 discover">
          <button
            onClick = {this.handlePrivateMessage.bind(this)}
            type="submit">
            <img src={msg}/>
          </button>
        </div>

        <div className="col-md-1 profil">
          <input
            onClick={this.handleProfil}
            type="button"
            value="PROFIL" />
        </div>

        <div className="col-md-1 logout">
          <input
            onClick = {this.changeBar.bind(this)}
            type="button"
            value="LOG OUT" />
        </div>
        <div className="col-md-2 right"><p> </p></div>
      </div>
    );
  }
}

export default LogoutNavPanel;
