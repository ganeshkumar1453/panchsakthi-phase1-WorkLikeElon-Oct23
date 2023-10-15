import { Component } from '@angular/core';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private modalService: NgbModal, private ngbActivity: NgbActiveModal){}

  public user = {
    name: "",
    totalTime: "",
    effectiveTime: "",
    shortBT: "",
    longBT: ""
  }

  list:any = [];

  public open(modal: any): void {
    const modalRef = this.modalService.open(modal);
    modalRef.result.then((res) => {
      this.list.push(res);
    console.log(this.list );
    });
    // console.log('open')
  }

  save(modal:any){
    modal.close(this.user);
  }

}
