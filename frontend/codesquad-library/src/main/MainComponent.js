import React, {Component} from 'react';
import {Navbar, SideNav, Button} from 'react-materialize';

class MainComponent extends Component {
    render() {
        return (
            <div className="component">
                <Navbar brand = '&nbsp;&nbsp;Codesquad-Library' right/>
            </div>
        )
    }
}

export default MainComponent;