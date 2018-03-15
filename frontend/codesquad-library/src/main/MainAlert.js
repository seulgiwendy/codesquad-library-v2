import React, {Component} from 'react';
import {Alert, Glyphicon} from 'react-bootstrap';
import './main.css';

class MainAlert extends Component {
    render() {
        return(
            <div className="main-body-bottom">
                <Alert bsStyle="warning">
                    책을 안 읽으면 멍청이가 됩니다. <strong>책을 읽으세요!</strong>
                </Alert>
                <Alert bsStyle="info">
                    4월 다독자 시상이 있을 예정입니다.
                </Alert>
            </div>
        )
    }
}

export default MainAlert;