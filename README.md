#hongik_grad_project_kky
====
2020 졸업 프로젝트 - 사용자 맞춤형 공연일정 관리 및 공연 정보 앱 개발

프로젝트 설명 Youtube: https://www.youtube.com/watch?v=hxGjGDSwan0&t=132s


팀원
---
* 강민채
* 김선혜
* 염연주



프로젝트 배경, 동기, 목적 및 내용
---
졸업 프로젝트를 기획하기에 앞서 공통의 관심사가 무엇인지에 대한 대화를 나눠보았다. 
그 결과 공연 예술 분야에 대해 관심이 많다는 데 의견이 모아졌고, 해당 분야의 내용을 활용할 수 있는 프로젝트를 하기로 했다.

콘서트, 뮤지컬과 같은 다양한 공연예술 산업이 현대인에게 점점 친숙하고 대중적인 문화로 자리 잡고 있다. 
하지만 공연 콘텐츠와 그에 관한 정보는 방대한데다가 각종 예매 사이트에 산재되어 있어 내가 원하는 공연, 내가 원하는 정보를 선별하는 것이 쉽지 않은 상황이다. 

이에 흩어져 있는 공연 정보를 한 데로 모아 효율적인 정보 검색을 가능하게 하고 장르, 출연진 등 개인 기호에 따라 사용자가 원하는 정보만을 따로 모아 관리할 수 있게 하는 앱을 개발하고자 한다. 
특히 티켓팅 날짜, 공연일과 같은 일정 정보가 공연에서 매우 중요하므로 관심 있는 공연의 일정을 쉽게 관리할 수 있도록 캘린더와 알림을 중심으로 서비스를 구성할 계획이다. 

사용자는 자신이 좋아하는 장르의 새로운 콘서트 정보를 쉽게 받아볼 수 있고 좋아하는 배우들이 참여하는 뮤지컬 일정을 캘린더에서 한눈에 확인할 수 있으며, 관심 있는 공연의 티켓팅 날, 티켓팅을 잊지 않도록 알림을 받을 수 있다.



구현할 기능
---
* 각종 공연에 대한 정보 제공
* 사용자가 선택한 공연의 일정(공연일, 티켓팅 날짜 등)을 캘린더에 등록
* 캘린더에 등록된 일정에 대한 미리 알림
* 관심 있는 공연자(배우, 가수 등)의 모든 공연에 대한 자동등록(구독) 또는 알림
* (추가) 사용자가 등록한 공연들의 장르, 공연자 등의 정보를 기반으로 다른 공연 맞춤 추천



구현을 위해 알아본 것
---
* Web Crawling - BeautifulSoup, Selenium
* Server - Azure, Spring boot
* Database - MySQL
* Language - Python, JAVA
