import React, {Component} from 'react';
import {Panel} from 'react-bootstrap';
import './main.css';

class MainFeatured extends Component {
    render() {
        return(
            <div className="container-fluid main-container">
                <Panel className="main-featured">
                    <Panel.Body>
                        Featured Articles
                        <h1 className="main-text">포비의 책장</h1>
                    </Panel.Body>
                </Panel>
                <Panel className="main-featured">
                    <Panel.Body>
                        Featured Articles
                        <h1 className="main-text">호눅스의 책장</h1>
                    </Panel.Body>
                </Panel>
                <Panel className="main-featured">
                    <Panel.Body>
                        Featured Articles
                        <h1 className="main-text">크롱의 책장</h1>
                    </Panel.Body>
                </Panel>                    
                <Panel className="main-featured">
                    <Panel.Body>
                        Featured Articles
                        <h1 className="main-text">JK의 책장</h1>
                    </Panel.Body>
                </Panel>
            </div>
        )
    }
}

export default MainFeatured;