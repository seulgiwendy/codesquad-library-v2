import React, {Component} from 'react';
import {Navbar, NavItem, MenuItem, NavDropdown, Nav, Jumbotron, Button} from 'react-bootstrap';
import './main.css'

class MainComponent extends Component {
    render() {
        return (
            <div className="main">
                <Navbar className="navbar-default">
                    <Navbar.Header>
                        <Navbar.Brand>
                            Codesquad Library
                        </Navbar.Brand>
                    </Navbar.Header>
                    <Nav className="navbar-letter">
                            <NavItem id = "navbar-menu" activehref="#"> 도서검색 </NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 도서관리 </NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 대출정보 </NavItem>
                    </Nav>
                    <Nav className="navbar-personal" pullRight>
                            <Button bsStyle = "primary" activehref="#" id = "navbar-button"> Login </Button>
                    </Nav>
                </Navbar>
                <div className="main-body">
                    <Jumbotron className = "main-jumbo">
                        <h1 id="jumbotron-h1">코드스쿼드 도서관</h1>
                        <p>
                            코드스쿼드의 도서 관리와 대여를 위한 페이지입니다. <br/>
                            책을 많이 읽읍시다.
                        </p>
                    </Jumbotron>
                    <br/>
                    <div className="main-body-lower">
                        <h1 id="main-h1">책을 많이 읽읍시다.</h1>
                    </div>
                </div>
            </div>
        
        )
    }
}

export default MainComponent;