import { LightningElement, api } from 'lwc';

export default class PaginationComponent extends LightningElement {
    @api currentPage = 1;
    @api totalPages = 1;

    get disableFirstPrev(){
        return this.currentPage <= 1;
    }

    get disableNextLast(){
        return this.currentPage >= this.totalPages;
    }

    handleFirst() {
        this.dispatchEvent(new CustomEvent('pagechange', { detail: 1}));
    }

    handleLast(){
        this.dispatchEvent(new CustomEvent('pagechange', { detail: this.totalPages}));
    }

    handleNext(){
        this.dispatchEvent(new CustomEvent('pagechange', { detail: this.currentPage < this.totalPages ? this.currentPage + 1 : this.totalPages}));
    }

    handlePrevious(){
        this.dispatchEvent(new CustomEvent('pagechange', { detail : this.currentPage > 1 ? this.currentPage - 1 : 1}));
    }
}