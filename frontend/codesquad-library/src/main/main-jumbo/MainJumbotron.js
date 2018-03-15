import '../main.css';
import React, { Component } from 'react';
import {Jumbotron} from 'react-bootstrap';

class MainJumbotron extends Component {
    render() {
        return(
            <div>
                <Jumbotron className = "main-jumbo">
                    <span >
                        <img className = "jumbo-img center-block" src="http://codesquad.kr/img/company/codesquad2.png" width="10%" height="10%"/>
                    </span>
                    <p className = "text-center">
                        코드스쿼드의 도서 관리와 대여를 위한 페이지입니다. 책을 많이 읽읍시다.
                    </p>
                </Jumbotron>
            </div>
        )
    }
}

export default MainJumbotron;