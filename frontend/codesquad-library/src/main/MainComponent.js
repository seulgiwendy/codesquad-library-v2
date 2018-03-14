import React, {Component} from 'react';
import {Navbar, NavItem, MenuItem, NavDropdown, Nav, Jumbotron, Button, Panel, Alert, Glyphicon} from 'react-bootstrap';
import './main.css'

class MainComponent extends Component {
    render() {
        return (
            <div className="main">
                <Navbar className="navbar-default" fixedTop={true}>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <strong id="navbar-title">Codesquad Library</strong>
                        </Navbar.Brand>
                    </Navbar.Header>
                    <Nav className="navbar-letter">
                            <NavItem id = "navbar-menu" activehref="#"> 도서검색 </NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 도서관리 </NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 대출정보 </NavItem>
                    </Nav>
                    <Nav className="navbar-personal" pullRight>
                            <Button bsStyle = "primary" activehref="#" id = "navbar-button"> Login </Button>
                            <Button bsStyle = "warning" activehref="#" id = "navbar-button"> 관리자 콘솔 </Button>
                    </Nav>
                </Navbar>
                <div className="main-body">
                    <Jumbotron className = "main-jumbo">
                        <span >
                            <img className = "jumbo-img center-block" src="http://codesquad.kr/img/company/codesquad2.png" width="10%" height="10%"/>
                        </span>
                        <p className = "text-center">
                            코드스쿼드의 도서 관리와 대여를 위한 페이지입니다. 책을 많이 읽읍시다.
                        </p>
                    </Jumbotron>
                    <br/>
                    <div className="main-body-lower">
                        <h1 className="main-text">책을 많이 읽읍시다.</h1>
                        <h3 className="main-text">여러분의 개발을 도와주는 많은 책들이 준비되어 있습니다.</h3>
                    </div>
                </div>
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
                <div className="main-body-bottom">
                    <Alert bsStyle="warning">
                        책을 안 읽으면 멍청이가 됩니다. <strong>책을 읽으세요!</strong>
                    </Alert>
                    <Alert bsStyle="info">
                        4월 다독자 시상이 있을 예정입니다.
                    </Alert>
                </div>
                <div className="container-fluid default-footer">
                    <div className="footer-content">
                        <p>Made with <Glyphicon glyph="heart"/> by wheejuni, All rights reserved.</p>
                        <p><Glyphicon glyph="envelope"/> &nbsp;<a href="mailto:me@wheejuni.com" id="footer-mail">me@wheejuni.com</a></p>
                    </div>
                </div>
            </div>
        
        )
    }
}

export default MainComponent;