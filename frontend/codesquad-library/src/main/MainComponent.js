import React, {Component} from 'react';
import MainNavbar from './main-navbar/MainNavbar';
import MainJumbotron from './main-jumbo/MainJumbotron';
import MainFooter from './MainFooter';
import MainFeatured from './MainFeatured';
import MainAlert from './MainAlert';
import './main.css'

class MainComponent extends Component {
    render() {
        return (
            <div className="main">
                <MainNavbar/>
                <div className="main-body">
                    <MainJumbotron/>
                    <br/>
                    <div className="main-body-lower">
                        <h1 className="main-text">책을 많이 읽읍시다.</h1>
                        <h3 className="main-text">여러분의 개발을 도와주는 많은 책들이 준비되어 있습니다.</h3>
                    </div>
                </div>
                <MainFeatured/>
                <MainAlert/>
                <div className="container-fluid default-footer">
                    <MainFooter/>
                </div>
            </div>
        
        )
    }
}

export default MainComponent;