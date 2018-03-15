import '../main.css';
import React, { Component } from 'react';
import {Nav, Navbar, NavItem, Button} from 'react-bootstrap';

class MainNavbar extends Component {
    render() {
        return(
            <div className="navbar-default">
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
            </div>
        )
    }
}

export default MainNavbar;