    


     function 计算个税(sal){     //工资、起征线、社保个人  
      var qzLine =3500; 
      var 计税 = sal - qzLine ;
     
      var 应交税 ;
       //
      if(计税 <0){
    	  return 0;
      }else if(计税 <1500){
          应交税=计税*0.03;
      }else if(计税 >= 1500 && 计税< 4500 ){
          应交税=计税*0.1-105;
      }else if(计税 >= 4500 && 计税< 9000 ){
          应交税=计税*0.2-555;
      }else if(计税 >= 9000 && 计税< 35000 ){
          应交税=计税*0.25-1005;
      }else if(计税 >= 35000 && 计税< 55000 ){
          应交税=计税*0.3-2755;
      }else if(计税 >= 55000 && 计税< 80000 ){
          应交税=计税*0.35-5505;
      }else if(计税 >=  80000 ){
          应交税=计税*0.45-13505;
      }

      return Math.round(应交税*100)/100;

      //console.log("应发工资="+(计税 -应交税 +3500));
 
  }

  // console.log(计算个税(15000,375));
