import React, { Component } from 'react';
import search from './css/search.png';
import './bootstrap/css/bootstrap.min.css';
import './nP_Logout.css';

class LogoutNavPanel extends Component {
  constructor(props){
    super(props);
  }

  render(){
    return(
      <div className="row one">
        <div className="col-md-2 right"><p> </p></div>
        <div className="col-md-2 logo">
          <input type="button" value="TWISTER" />
        </div>
        <div className="col-md-4 search">
          <input type="text" value="SEARCH ..."/>
          <button type="submit"><img src={search}/></button>
        </div>

        <div className="col-md-1 profil">
          <input type="button" value="PROFIL" />
        </div>

        <div className="col-md-1 logout">
          <input onClick = { this.props.setLogout }type="button" value="LOG OUT" />
        </div>
        <div className="col-md-2 right"><p> </p></div>
      </div>
    );
  }
}

export default LogoutNavPanel;
