import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import marbleEstompe from './css/marbleEstompe.jpeg';
import search from './css/search.png';
import './bootstrap/css/bootstrap.min.css';
import './css/NavigationPanel.css';
import WelcomePage from './WelcomePage.js';

class NavigationPanel extends Component {

	constructor(props){
  		super(props);
			this.state = { logout : false, profil : false, search : false };
			this.setLogout = this.setLogout.bind(this);
			this.clickProfil = this.clickProfil.bind(this);
			this.clickSearch = this.clickSearch .bind(this);
  }

	setLogout(){
		this.setState({ logout : true });
	}

	clickProfil(){
		this.setState({ profil : true });
	}

	clickSearch(){
		this.setState({ search : true });
	}

  	render(){
			if(this.state.logout == true){
				return (<WelcomePage />);
			}

  		return (
  	/*	<div className="NavigationPanel">
  			<nav
  			/>
  		</div>*/
			<div class="row one">
				<div class="col-md-2 right"><p> </p></div>
				<div class="col-md-2 logo">
					<input type="button" value="TWISTER" />
				</div>
				<div class="col-md-4 search">
					<input type="text" placeholder="SEARCH ..."/>
					<button type="submit"><img src={search}/></button>
				</div>

				<div class="col-md-1 profil">
					<input type="button" value="PROFIL" />
				</div>

				<div class="col-md-1 logout">
					<input type="button" value="LOG OUT" />
				</div>
				<div class="col-md-2 right"><p> </p></div>
			</div>

			 /*   <div className="row two">
			      <div className="col-md-2 right"><p> </p></div>
			      <div className="col-md-8 center">
			        <span> HELLO ! HOW ARE YOU DOING ?</span>
			        <div class="post">
			          <label for="post" ></label>
			          <input type="text" name="post" id="post" /><br />
			        </div>

			        <div className="enter">
			          <label for="submit"></label>
			          <input type="submit" name="submit" id="submit" value="Enter" /><br />
			        </div>
			      </div>
			      <div className="col-md-2 left"><p> </p></div>
			    </div>*/
			);
  	}
  }
export default NavigationPanel;
