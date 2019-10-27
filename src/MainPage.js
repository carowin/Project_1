import React, { Component } from 'react';
import NavigationPanel from './NavigationPanel';
import ContentPanel from './ContentPanel';
import axios from 'axios';
import Cookies from 'universal-cookie';


export const cookie = new Cookies();

class MainPage extends Component {
  constructor(props){
    super(props);

  	this.state = {
    isConnected : false,
    pageCourante : 'connection',
    listFriend: [],
    //listMessage: [],
    whoProfil: 'me',
    current_id:'',
    searchBar:'false'
    };

    cookie.set("mykey","ko");
    cookie.set("mylog", "ko");
    cookie.set("myid", "ko");

    this.setSignIn = this.setSignIn.bind(this);
    this.setSignUp = this.setSignUp.bind(this);
    this.setLogout = this.setLogout.bind(this);
    this.setProfil = this.setProfil.bind(this);
    this.setWall = this.setWall.bind(this);
    this.setListFriend = this.setListFriend.bind(this);
    this.setSearchBar = this.setSearchBar.bind(this);

    this.setWhoProfil = this.setWhoProfil.bind(this);
    this.setConnection = this.setConnection.bind(this);
    this.setCurrendId = this.setCurrendId.bind(this);

    this.getMyListFriend = this.getMyListFriend.bind(this);
    this.getSearchBarFriend = this.getSearchBarFriend.bind(this);
    this.setPrivateMessage = this.setPrivateMessage.bind(this);
//this.getMessage = this.getMessage.bind(this);
  }

  setSignIn(){
    this.setState({pageCourante : 'signInForm'});
  }

  setSignUp(){
    this.setState({pageCourante : 'signUpForm'});
  }

  setLogout(){
    this.setState({pageCourante : 'connection'});
  }

  setWall(){
    this.setState({pageCourante : 'mur de tweet'});
  }

  setProfil(){
    this.setState({pageCourante : 'profil'});
  }

  setListFriend(){
    this.setState({pageCourante : 'friend'});
  }

  setPrivateMessage(){
      this.setState({pageCourante : 'private message'});
  }

  setWhoProfil(name){
    this.setState({whoProfil: name});
  }

  setConnection(bool){
    this.setState({isConnected : bool});
  }

  setCurrendId(id){
    this.setState({current_id : id});
  }

  setSearchBar(bool){
    this.setState({searchBar: bool});
  }

  getMyListFriend(){
    var self = this;
    var formData = new URLSearchParams();
    formData.append('key', cookie.get("mykey"));
    axios.get('http://localhost:8080/Twister/Servlets/ListFriend?'+formData)
      .then (response => {
        self.setState({listFriend: response.data.AmisName});
      })
      .catch(r => { alert("Erreur"); });
  }

  getSearchBarFriend(query){
    var self = this;
    var formData = new URLSearchParams();
    formData.append("search", query);
    axios.get('http://localhost:8080/Twister/Servlets/SearchFriend?'+formData)
    .then (r => {
      self.setState({listFriend: r.data.search});
    })
    .catch(r => {alert("ERROR")});
  }
/*
  getMessage(id){
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

  render(){
    let navPanel, contentPanel;

    navPanel = <NavigationPanel
                  isConnected={this.state.isConnected}
                  searchBar={this.state.searchBar}
                  setSearchBar={this.setSearchBar}
                  getSearchBarFriend={this.getSearchBarFriend}

                  signIn={this.setSignIn}
                  signUp={this.setSignUp}
                  setLogout={this.setLogout}
                  profil={this.setProfil}
                  setWall={this.setWall}
                  setConnection= {this.setConnection}
                  setWhoProfil={this.setWhoProfil}
                  setCurrendId={this.setCurrendId}
                  setFriend={this.setListFriend}
                  setPrivateMessage={this.setPrivateMessage}
               />;
    contentPanel = <ContentPanel
                      isConnected={this.state.isConnected}
                      whoProfil={this.state.whoProfil}
                      pageCourante={this.state.pageCourante}
                      listFriend={this.state.listFriend}
                      currentId={this.state.current_id}
                      searchBar={this.state.searchBar}
                      setSearchBar={this.setSearchBar}
                      getSearchBarFriend={this.getSearchBarFriend}

                      //listMessage={this.state.listMessage}
                      //getMessage={this.getMessage}

                      signIn={this.setSignIn}
                      signUp={this.setSignUp}
                      setLogout={this.setLogout}
                      profil={this.setProfil}
                      setWall={this.setWall}
                      setFriend={this.setListFriend}
                      setConnection= {this.setConnection}

                      getMyListFriend={this.getMyListFriend}
                      setWhoProfil={this.setWhoProfil}
                      setCurrendId={this.setCurrendId}
                      setPrivateMessage={this.setPrivateMessage}

                   />;

    return (<div> {navPanel}{contentPanel}</div>);
  }
}

export default MainPage;
