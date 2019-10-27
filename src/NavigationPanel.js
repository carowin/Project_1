import React, { Component } from 'react';
import Login from './LoginNavPanel.js';
import Logout from './LogoutNavPanel.js';
import {cookie} from './MainPage';

class NavigationPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
    if(this.props.isConnected === false){
      return(<Login
              signIn= {this.props.signIn}
              signUp= {this.props.signUp}/>);
    }
    if(this.props.isConnected === true){
      return(<Logout
              setLogout={this.props.setLogout}
              setConnection= {this.props.setConnection}
              log={this.props.log}
              profil={this.props.profil}
              setWall= {this.props.setWall}
              setWhoProfil={this.props.setWhoProfil}
              setCurrendId={this.props.setCurrendId}
              setFriend={this.props.setFriend}
              searchBar={this.props.searchBar}
              setSearchBar={this.props.setSearchBar}
              getSearchBarFriend={this.props.getSearchBarFriend}
              setPrivateMessage={this.props.setPrivateMessage}
              />);
    }
  }
}

export default NavigationPanel;
