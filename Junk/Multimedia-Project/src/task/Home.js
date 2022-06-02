import React from 'react';
import axios from 'axios';
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js";
import "../navbar/Navbar.css";
import "@ui5/webcomponents/dist/Input.js";
import "@ui5/webcomponents/dist/Link";
import BIRDS from 'vanta/dist/vanta.birds.min'
import "@ui5/webcomponents/dist/Carousel.js";
import o1 from '../images/o1.jpg';
import o2 from '../images/o2.png';
import o3 from '../images/o3.jpg';
import o4 from '../images/o4.jpg';
import o5 from '../images/o5.jpg';
import o8 from '../images/o8.jpg';
import o9 from '../images/o9.jpg';
import YouTube from 'react-youtube';

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      t1: "Орлите са големи грабливи птици, които се срещат най-вече в Стария свят. Едва 2 вида (скалния орел и белоглавия орел) са разпространени в Северна Америка и само няколко в Южна Америка. Те са членове на разред Ястребоподобни, на семейство Ястребови и на различни родове, които не са задължително близки един на друг. Отличителните им белези са як клюн, закривен надолу и сърповидни нокти. Клюнът помага за лесното и бързо хващане на жертвата, а ноктите – за убиването ѝ. ",
      t2: "Така, както лъвът се разглежда като цар на животните, орелът се разглежда като цар на птиците и е издигната птица в хералдиката. Като такъв, орелът бива едноглав или двуглав.",
      url: "A9WDwo4JKCE",
      o: "Орел"

    };
    this.vantaRef = React.createRef()
    this.test = this.test.bind(this);
    this.orel = this.orel.bind(this);
    this.buhal = this.buhal.bind(this);
    this.z = this.z.bind(this);
    this.x = this.x.bind(this);
    this.c = this.c.bind(this);
    this.v = this.v.bind(this);
  }
  componentDidMount() {
    this.vantaEffect = BIRDS({
      el: this.vantaRef.current,
      mouseControls: true,
      touchControls: true,
      gyroControls: true,
      minHeight: 200.00,
      minWidth: 200.00,
      scale: 1.00,
      scaleMobile: 1.00,
      backgroundColor: 0xffffff,
      birdSize: 1.90,
      wingSpan: 10.00,
      separation: 94.00,
      alignment: 35.00,
      cohesion: 22.00,
      quantity: 4.00
    })
  }
  componentWillUnmount() {
    if (this.vantaEffect) this.vantaEffect.destroy()
  }

  test() {
    this.setState({
      b: 1
    })
  }

  orel(){

    this.setState({
      t1: "Орлите са големи грабливи птици, които се срещат най-вече в Стария свят. Едва 2 вида (скалния орел и белоглавия орел) са разпространени в Северна Америка и само няколко в Южна Америка. Те са членове на разред Ястребоподобни, на семейство Ястребови и на различни родове, които не са задължително близки един на друг. Отличителните им белези са як клюн, закривен надолу и сърповидни нокти. Клюнът помага за лесното и бързо хващане на жертвата, а ноктите – за убиването ѝ. ",
      t2: "Така, както лъвът се разглежда като цар на животните, орелът се разглежда като цар на птиците и е издигната птица в хералдиката. Като такъв, орелът бива едноглав или двуглав.",
      url: "A9WDwo4JKCE",
      o: "Орел"
    })
  }

  buhal(){
    this.setState({
      t1: "Бухалът е най-едрата нощна граблива птица, срещаща се в България. Дължина на тялото достига до около 67 cm, а тази на крилете – до 1,4 – 2 m. Теглото им е около 3 kg. Очите и човката му са разположени на своеобразно лице, характерно за Совови.",
      t2: "Бухалът ловува през нощта. В различните области плячка за него са най-разнообразни животни – плъхове, мишки, зайци. Яде и мърша от тези видове, както и млади и възрастни лисици, златки и други хищници до едри насекоми, най-често бръмбари, дори раци и риба.",
      url: "bt3X8MJgJWo",
      o: "Бухал"
    }) 
  }

z() {
  this.setState({
    t1: "Соколите са род дневни грабливи птици от семейство Соколови, срещащи се и в България. Размерите им варират от дребни до средно големи видове, окраската също е силно разнообразна, най-често в камуфлажни цветове.",
    t2: "Някои от видовете в рода, като сокол скитник и сокол орко са считани за най-бързо летящите птици, достигащи до близо 400 km/h при пикиране и близо до 200 km/h при хоризонтален полет. Общо взето не ускоряват така бързо и не са толкова маневрени като ястребите, но в открито небе развиват много по-големи скорости.",
    url: "iE46Ta0Akew",
    o:"Сокол"
  })
}

x(){
  this.setState({
    t1: "Ястребите са средни по размер дневни грабливи птици от семейство Ястребови (Accipitridae). Имат изразен полов диморфизъм, като женската най-често е по-едра от мъжкия.",
    t2: "Хищни птици, основната част от храната им се състои от дребни и средни по размери птици. Малък дял се пада на бозайниците, влечугите и други животни. Гнездят най-често по дърветата. Снасят 2-6 яйца. Мъти 28-38 дни предимно женската, въпреки че при някои видове като напр. Големият ястреб и мъжкия взема участие.",
    url : "CNi6qKdqDw0",
    o: "Ястреб"
  })
}

c(){
  this.setState({
    t1: "Ветрушката е птица от семейство Соколови. Среща се и в България и е вид много близък с керкенеза (който е наричан и черношипа ветрушка), но е по-дребен. ",
    t2: "Храни се предимно с едри скакалци, но лови също така дребни гущери и змии. Когато ловува, понякога застава неподвижно във въздуха, трептейки с криле, което ѝ позволява да оглежда и следи района достатъчно време, за да се покажат скрилите се за момент или останали неподвижни по друга причина жертви, и обикновено не се отдалечава много от колонията си.",
    url : "UgN0EtZEt84",
    o: "Ветрушка"
  })
}

v(){
  this.setState({
    t1: "Совата е птица от семейство Совови. Среща се и в България. По външен вид напомня бухал, но е значително по-дребна. Размахът на крилете ѝ е около 86 – 98 cm, дължината на тялото – 31 – 37 и тежи между 220 и 650 гр.",
    t2: "Среща се във всякакви типове гори-иглолистни, широколистни и смесени, в равнини, низини и планини, ако е оставена на спокойствие се заселва и в паркове, но като цяло отдава предпочитание на иглолистите гори. В по-студените северни райони се доближава повече до човешките поселения. В северните райони е прелетна, в зоните с умерен и субтропичен климат в Европа, Азия и северна Африка води уседнал начин на живот и в тропиците се появява предимно за да зимува.",
    url: "0fECi8Ll-QE",
    o: "Сова"
  })

}

  render() {
    const opts = {
      height: '274',
      width: '452',
      playerVars: {
        // https://developers.google.com/youtube/player_parameters
        autoplay: 0,
      },
    };
    return <div>

      <div className="birds-background" ref={this.vantaRef}></div>
      <div className="topnav">
        <div>Самостоятелна работа по мултумедийно представяне</div>
        <div>
          <a href="#">Начало</a>
          <a href="#">За нас</a>
          <a href="#">Контакти</a>
        </div>
      </div>
      <div className="title">
        <h1>Грабливи птици в България</h1>
        <h5>Проект към курс CSCB699. НБУ 2021г.</h5>
      </div>
      <div className="photo">
        <img onClick={this.orel} src={o1} alt="fireSpot" />
        <img onClick={this.buhal} src={o2} alt="fireSpot" />
        <img onClick={this.z} src={o4} alt="fireSpot" />
      </div>
      <div className="photo1">
        <img onClick={this.x} src={o5} alt="fireSpot" />
        <img onClick={this.c} src={o8} alt="fireSpot" />
        <img onClick={this.v} src={o9} alt="fireSpot" />
      </div>
      <div className="info">
        <h2>{this.state.o}</h2>
        <p>{this.state.t1}</p>
        <hr />
        <p><i>{this.state.t2}</i></p>
        <YouTube className="video" videoId={this.state.url} opts={opts} onReady={this._onReady} />
      </div>
    </div>
  }
}
export default Home;