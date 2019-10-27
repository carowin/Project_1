import React, { Component } from 'react';
import WelcomeForm from './WelcomeForm.js';
import SignInForm from './SignInForm.js';
import SignUpForm from './SignUpForm.js';
import MenuPage from './MenuPage.js';
import ProfilPage from './ProfilPage.js';
import FriendPanel from './FriendPanel.js';
import MessagePanel from './MessagePanel.js';
import {cookie} from './MainPage';

class ContentPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
      if(this.props.pageCourante === 'connection') {
        return(<WelcomeForm  />);
      }

      if(this.props.pageCourante === 'signInForm') {
        return <SignInForm
                    setWall={this.props.setWall}
                    setConnection= {this.props.setConnection}
                    setLog= {this.props.setLog}
                    log={this.props.log}
                    setCurrendId={this.props.setCurrendId}
                    />;
      }

      if(this.props.pageCourante === 'signUpForm') {
        return <SignUpForm
                    setLogout={this.props.setLogout}
                   />;
      }

      if(this.props.pageCourante === 'mur de tweet') {
        return <MenuPage
                  pageCourante={this.props.pageCourante}
                  whoProfil={this.props.whoProfil}
                  currentId={this.props.currentId}

                  setCurrendId={this.props.setCurrendId}

                //  listMessage={this.props.listMessage}
                //  getMessage={this.props.getMessage}
               />;
      }

      if(this.props.pageCourante === 'profil'){
        return <ProfilPage
                  pageCourante={this.props.pageCourante}
                  currentId={this.props.currentId}
                  whoProfil={this.props.whoProfil}

                  setFriend={this.props.setFriend}
                  getMyListFriend={this.props.getMyListFriend}
                  setCurrendId={this.props.setCurrendId}

                  //listMessage={this.props.listMessage}
                  //getMessage={this.props.getMessage}
              />;
      }

      if(this.props.pageCourante === 'friend'){
        return <FriendPanel
                  whoProfil={this.props.whoProfil}
                  listFriend = {this.props.listFriend}
                  currentId={this.props.currentId}
                  setFriend={this.props.setFriend}
                  setWhoProfil={this.props.setWhoProfil}
                  profil={this.props.profil}
                  setCurrendId={this.props.setCurrendId}
                  searchBar={this.props.searchBar}
              />;
      }

      if(this.props.pageCourante === 'private message'){
        return <MessagePanel />;
      }

      return null;

  }
}
export default ContentPanel;
