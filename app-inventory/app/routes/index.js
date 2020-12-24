import Route from '@ember/routing/route';

export default class IndexRoute extends Route {

    async model() {

    //   fetch('http://localhost:8080/employees/', {
    //     method: 'GET'
    //    })
    //  .then(function(response) { return response.json(); })
    // .then(json =>{

    //   console.log(json); })

    //   fetch('/api/test.json')
    //  .then(response => response.json())
    //   .then(data => console.log(data));

      let response = await fetch('/api/test.json');

      //let {data} = await response.json();
      return response.json(

        // model => {


        // let { name , email,  company} = model;
        // console.log(name, email);
        // return {name, email, ...company};
      //}
      );
    }
  }
