import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {
  itens: any[] = [];

  adicionarAoCarrinho(produto: any) {
    this.itens.push(produto);
  }

  obterItens() {
    return this.itens;
  }

  limparCarrinho() {
    this.itens = [];
  }

  atualizarItens(itensAtualizados: any[]) {
    this.itens = itensAtualizados;
  }
}
