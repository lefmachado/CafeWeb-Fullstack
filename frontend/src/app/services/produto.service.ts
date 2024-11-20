import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  produtos = [
    {
      id: 1,
      nome: 'Café Expresso',
      preco: 7.00,
      descricao: 'Café forte e puro, sem leite.',
      imagem: 'https://images.unsplash.com/photo-1610889556528-9a770e32642f?q=80&w=1915&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café Expresso é uma bebida intensa e de sabor concentrado, originada na Itália. Preparado com café moído na hora e água quente sob pressão, ele é perfeito para quem busca uma experiência autêntica e revigorante.'
    },
    {
      id: 2,
      nome: 'Café Latte',
      preco: 10.00,
      descricao: 'Café com leite suave e cremoso.',
      imagem: 'https://images.unsplash.com/photo-1602671784371-042db95df1c9?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café Latte é uma combinação suave de café expresso com leite vaporizado, criado para proporcionar uma experiência cremosa e delicada. É uma escolha popular entre aqueles que preferem um café mais leve e saboroso.'
    },
    {
      id: 3,
      nome: 'Café Mocha',
      preco: 12.00,
      descricao: 'Café com leite e chocolate.',
      imagem: 'https://images.unsplash.com/photo-1618576230663-9714aecfb99a?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café Mocha é uma deliciosa mistura de café, leite e chocolate, ideal para quem aprecia o sabor suave do chocolate combinado com a intensidade do café. Popular nos Estados Unidos, é perfeito para os dias mais frios.'
    },
    {
      id: 4,
      nome: 'Café Americano',
      preco: 8.00,
      descricao: 'Café mais leve e diluído.',
      imagem: 'https://plus.unsplash.com/premium_photo-1723559972702-2659e41dbb5b?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café Americano é conhecido por sua leveza e sabor suave. É feito adicionando água quente ao café expresso, criando uma bebida mais diluída que é muito popular na América do Norte.'
    },
    {
      id: 5,
      nome: 'Cappuccino',
      preco: 14.00,
      descricao: 'Café com espuma de leite e chocolate em pó.',
      imagem: 'https://images.unsplash.com/photo-1509042239860-f550ce710b93?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60',
      historia: 'O Cappuccino é um clássico italiano feito com partes iguais de café expresso, leite vaporizado e espuma de leite. Muitas vezes, é polvilhado com chocolate em pó para um toque extra de sabor.'
    },
    {
      id: 6,
      nome: 'Macchiato',
      preco: 15.0,
      descricao: 'Café expresso com um toque de espuma de leite.',
      imagem: 'https://images.unsplash.com/photo-1689358931339-cf2ccd39e7b1?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Macchiato é uma variação do expresso com uma pequena quantidade de espuma de leite, adicionando uma textura cremosa sem diluir o sabor intenso do café.'
    },
    {
      id: 7,
      nome: 'Café Gelado',
      preco: 8.00,
      descricao: 'Café refrescante servido com gelo.',
      imagem: 'https://images.unsplash.com/photo-1531835207745-506a1bc035d8?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café Gelado é ideal para os dias quentes, combinando o sabor do café com a refrescância do gelo. Muito popular em regiões tropicais e durante o verão.'
    },
    {
      id: 8,
      nome: 'Café com Leite',
      preco: 9.00,
      descricao: 'Mistura de café com leite quente.',
      imagem: 'https://images.unsplash.com/photo-1626436273480-05ec72d48442?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
      historia: 'O Café com Leite é uma combinação simples e tradicional, muito apreciada no café da manhã. A mistura do leite quente com o café cria um sabor suave e agradável.'
    }
  ];

  constructor() { }

  listarProdutos(): Observable<any[]> {
    return of(this.produtos);
  }

  obterProdutoPorId(id: number): Observable<any> {
    return of(this.produtos.find(produto => produto.id === id));
  }
}
