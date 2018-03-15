import React, {Component} from 'react';
import {Glyphicon} from 'react-bootstrap';
import './main.css';

class MainFooter extends Component {
    render() {
        return(
            <div className="footer-content">
                <p>Made with <Glyphicon glyph="heart"/> by wheejuni, All rights reserved.</p>
                <p><Glyphicon glyph="envelope"/> &nbsp;<a href="mailto:me@wheejuni.com" id="footer-mail">me@wheejuni.com</a></p>
            </div>
        )
    }
}

export default MainFooter;