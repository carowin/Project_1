import React, { Component } from 'react';
import Login from './LoginNavPanel.js';
import Logout from './LogoutNavPanel.js';

class NavigationPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
    if(this.props.isConnected === false){
      return(<Login signIn= {this.props.signIn} signUp= {this.props.signUp}/>);
    }
    if(this.props.isConnected === true){
      return(<Logout logout={this.props.logout} />);
    }
  }
}

export default NavigationPanel;
