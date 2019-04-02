import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import marbleEstompe from './css/marbleEstompe.jpeg';
import search from './css/search.png';
import WelcomeForm from './WelcomeForm.js';
import SignInForm from './SignInForm.js';
import SignUpForm from './SignUpForm.js';
import MenuPage from './MenuPage.js';

class ContentPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
      if(this.props.pageCourante === 'connection') {
        return(<WelcomeForm  />);
      }

      if(this.props.pageCourante === 'signInForm') {
        return <SignInForm signIn={this.props.signIn} login={this.props.login} />;
      }

      if(this.props.pageCourante === 'signUpForm') {
        return <SignUpForm signUp={this.props.signUp} />;
      }
      if(this.props.pageCourante === 'mur de tweet') {
        return <MenuPage/>;
      }
      return null;

  }
}
export default ContentPanel;
