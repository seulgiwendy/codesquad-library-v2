import React, {Component} from 'react';
import {Navbar, NavItem, MenuItem, NavDropdown, Nav, Jumbotron} from 'react-bootstrap';
import '../App.css'

const styles = {
    navbar: {
        backgroundColor : 'black',
        margin : 0
    },
    navbarLetter : {
        color : 'white'  
    }
}


class MainComponent extends Component {
    render() {
        return (
            <div className="main">
                <Navbar style = {styles.navbar}>
                    <Navbar.Header>
                        <Navbar.Brand>
                            Codesquad Library
                        </Navbar.Brand>
                    </Navbar.Header>
                    <Nav>
                            <NavItem id = "navbar-menu" href="#"> 도서검색 </NavItem>
                            <NavItem id = "navbar-menu" href="#"> 도서관리 </NavItem>
                            <NavItem id = "navbar-menu" href="#"> 대출정보 </NavItem>
                        
                    </Nav>
                </Navbar>
                <div className="main-body">
                    <Jumbotron className = "main-jumbo">
                        <h1 id="jumbotron-h1">hello world</h1>
                        <p>
                            코드스쿼드의 도서 관리와 대여를 위한 페이지입니다.
                        </p>
                    </Jumbotron>
                </div>
            </div>
        
        )
    }
}

export default MainComponent;