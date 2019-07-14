package com.mpxds.apirest.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mpxds.apirest.model.MpCategoria;
import com.mpxds.apirest.model.MpCidade;
import com.mpxds.apirest.model.MpCliente;
import com.mpxds.apirest.model.MpEndereco;
import com.mpxds.apirest.model.MpEstado;
import com.mpxds.apirest.model.MpItemPedido;
import com.mpxds.apirest.model.MpPagamento;
import com.mpxds.apirest.model.MpPagamentoComBoleto;
import com.mpxds.apirest.model.MpPagamentoComCartao;
import com.mpxds.apirest.model.MpPedido;
import com.mpxds.apirest.model.MpProduto;
import com.mpxds.apirest.model.MpSistemaConfig;
import com.mpxds.apirest.model.MpTabelaInterna;
import com.mpxds.apirest.model.enums.MpEstadoPagamento;
import com.mpxds.apirest.model.enums.MpPerfil;
import com.mpxds.apirest.model.enums.MpTipoCampo;
import com.mpxds.apirest.model.enums.MpTipoCliente;
import com.mpxds.apirest.model.enums.MpTipoTabelaInterna;
import com.mpxds.apirest.repository.MpCategoriaRepository;
import com.mpxds.apirest.repository.MpCidadeRepository;
import com.mpxds.apirest.repository.MpClienteRepository;
import com.mpxds.apirest.repository.MpEnderecoRepository;
import com.mpxds.apirest.repository.MpEstadoRepository;
import com.mpxds.apirest.repository.MpItemPedidoRepository;
import com.mpxds.apirest.repository.MpPagamentoRepository;
import com.mpxds.apirest.repository.MpPedidoRepository;
import com.mpxds.apirest.repository.MpProdutoRepository;
import com.mpxds.apirest.repository.MpSistemaConfigRepository;
import com.mpxds.apirest.repository.MpTabelaInternaRepository;

@Service
public class MpDBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private MpCategoriaRepository categoriaRepository;
	@Autowired
	private MpProdutoRepository produtoRepository;
	@Autowired
	private MpEstadoRepository estadoRepository;
	@Autowired
	private MpCidadeRepository cidadeRepository;
	@Autowired
	private MpClienteRepository clienteRepository;
	@Autowired
	private MpEnderecoRepository enderecoRepository;
	@Autowired
	private MpPedidoRepository pedidoRepository;
	@Autowired
	private MpPagamentoRepository pagamentoRepository;
	@Autowired
	private MpItemPedidoRepository itemPedidoRepository;
	//
	@Autowired
	private MpTabelaInternaRepository mpTabelaInternaRepository;
	@Autowired
	private MpSistemaConfigRepository mpSistemaConfigRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		//
		MpTabelaInterna tab1 = new MpTabelaInterna(null, MpTipoTabelaInterna.TB_INDICACAO, "j", "Jornal");
		MpTabelaInterna tab2 = new MpTabelaInterna(null, MpTipoTabelaInterna.TB_INDICACAO, "g", "google");
		
		mpTabelaInternaRepository.saveAll(Arrays.asList(tab1, tab2));
		//
		MpSistemaConfig sc1 = new MpSistemaConfig("param_email_suporte", "Email Suporte", MpTipoCampo.TEXTO,
																	"suporte@mpxds.com.br", BigDecimal.ZERO, false, "");
		MpSistemaConfig sc2 = new MpSistemaConfig("param_email_sac", "Email Suporte", MpTipoCampo.TEXTO,
																	"sac@mpxds.com.br", BigDecimal.ZERO, false, "");
		mpSistemaConfigRepository.saveAll(Arrays.asList(sc1, sc2));
		//
		MpCategoria cat1 = categoriaRepository.save(new MpCategoria(null, "Informática"));
		MpCategoria cat2 = categoriaRepository.save(new MpCategoria(null, "Escritório"));
		MpCategoria cat3 = categoriaRepository.save(new MpCategoria(null, "Cama mesa e banho"));
		MpCategoria cat4 = categoriaRepository.save(new MpCategoria(null, "Eletrônicos"));
		MpCategoria cat5 = categoriaRepository.save(new MpCategoria(null, "Jardinagem"));
		MpCategoria cat6 = categoriaRepository.save(new MpCategoria(null, "Decoração"));
		MpCategoria cat7 = categoriaRepository.save(new MpCategoria(null, "Perfumaria"));
		//
		MpProduto p1 = produtoRepository.save(new MpProduto(null, "Computador", 2000.00));
		MpProduto p2 = produtoRepository.save(new MpProduto(null, "Impressora", 800.00));
		MpProduto p3 = produtoRepository.save(new MpProduto(null, "Mouse", 80.00));
		MpProduto p4 = produtoRepository.save(new MpProduto(null, "Mesa de escritório", 300.00));
		MpProduto p5 = produtoRepository.save(new MpProduto(null, "Toalha", 50.00));
		MpProduto p6 = produtoRepository.save(new MpProduto(null, "Colcha", 200.00));
		MpProduto p7 = produtoRepository.save(new MpProduto(null, "TV true color", 1200.00));
		MpProduto p8 = produtoRepository.save(new MpProduto(null, "Roçadeira", 800.00));
		MpProduto p9 = produtoRepository.save(new MpProduto(null, "Abajour", 100.00));
		MpProduto p10 = produtoRepository.save(new MpProduto(null, "Pendente", 180.00));
		MpProduto p11 = produtoRepository.save(new MpProduto(null, "Shampoo", 90.00));
		
		MpProduto p12 = produtoRepository.save(new MpProduto(null, "MpProduto 12", 10.00));
		MpProduto p13 = produtoRepository.save(new MpProduto(null, "MpProduto 13", 10.00));
		MpProduto p14 = produtoRepository.save(new MpProduto(null, "MpProduto 14", 10.00));
		MpProduto p15 = produtoRepository.save(new MpProduto(null, "MpProduto 15", 10.00));
		MpProduto p16 = produtoRepository.save(new MpProduto(null, "MpProduto 16", 10.00));
		MpProduto p17 = produtoRepository.save(new MpProduto(null, "MpProduto 17", 10.00));
		MpProduto p18 = produtoRepository.save(new MpProduto(null, "MpProduto 18", 10.00));
		MpProduto p19 = produtoRepository.save(new MpProduto(null, "MpProduto 19", 10.00));
		MpProduto p20 = produtoRepository.save(new MpProduto(null, "MpProduto 20", 10.00));
		
		cat1.getMpProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20));
		
		p12.getMpCategorias().add(cat1);
		p13.getMpCategorias().add(cat1);
		p14.getMpCategorias().add(cat1);
		p15.getMpCategorias().add(cat1);
		p16.getMpCategorias().add(cat1);
		p17.getMpCategorias().add(cat1);
		p18.getMpCategorias().add(cat1);
		p19.getMpCategorias().add(cat1);
		p20.getMpCategorias().add(cat1);
		
		cat1.getMpProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getMpProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getMpProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getMpProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getMpProdutos().addAll(Arrays.asList(p8));
		cat6.getMpProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getMpProdutos().addAll(Arrays.asList(p11));
		
		p1.getMpCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getMpCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getMpCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getMpCategorias().addAll(Arrays.asList(cat2));
		p5.getMpCategorias().addAll(Arrays.asList(cat3));
		p6.getMpCategorias().addAll(Arrays.asList(cat3));
		p7.getMpCategorias().addAll(Arrays.asList(cat4));
		p8.getMpCategorias().addAll(Arrays.asList(cat5));
		p9.getMpCategorias().addAll(Arrays.asList(cat6));
		p10.getMpCategorias().addAll(Arrays.asList(cat6));
		p11.getMpCategorias().addAll(Arrays.asList(cat7));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
												p12, p13, p14, p15, p16, p17, p18, p19, p20));
		//
		MpEstado est1 = estadoRepository.save(new MpEstado(null, "Minas Gerais"));
		MpEstado est2 = estadoRepository.save(new MpEstado(null, "São Paulo"));
		
		MpCidade c1 = cidadeRepository.save(new MpCidade(null, "Uberlândia", est1));
		MpCidade c2 = cidadeRepository.save(new MpCidade(null, "São Paulo", est2));
		MpCidade c3 = cidadeRepository.save(new MpCidade(null, "Campinas", est2));
		
		est1.getMpCidades().addAll(Arrays.asList(c1));
		est2.getMpCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		//
		MpCliente cli1 = new MpCliente(null, "Maria Silva", "nelio.cursos@gmail.com", "36378912377", 
																			MpTipoCliente.PESSOAFISICA, pe.encode("123"));		
		cli1.getTelefones().addAll(Arrays.asList("(21) 2736-3323", "(21) 99383-8393"));
		cli1 = clienteRepository.save(cli1);
		//
		MpCliente cli2 = new MpCliente(null, "Ana Costa", "nelio.iftm@gmail.com", "31628382740", 
																			MpTipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("(21) 9388-3321", "(21) 3425-2625"));
		cli2.addPerfil(MpPerfil.ADMIN);
		cli2 = clienteRepository.save(cli2);
		//
		MpEndereco e1 = enderecoRepository.save(new MpEndereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834",
																													cli1, c1));
		MpEndereco e2 = enderecoRepository.save(new MpEndereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012",
																													cli1, c2));
		MpEndereco e3 = enderecoRepository.save(new MpEndereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012",
																													cli2, c2));
		//
		cli1.getMpEnderecos().addAll(Arrays.asList(e1, e2));
		cli1 = clienteRepository.save(cli1);
		cli2.getMpEnderecos().addAll(Arrays.asList(e3));
		cli2 = clienteRepository.save(cli2);
		//
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
//		MpPedido ped1 = pedidoRepository.save(new MpPedido(1, sdf.parse("30/09/2017 10:32"), cli1, e1));
//		MpPedido ped2 = pedidoRepository.save(new MpPedido(2, sdf.parse("10/10/2017 19:35"), cli1, e2));
		
//		MpPagamento pagto1 = pagamentoRepository.save(new MpPagamentoComCartao(1, MpEstadoPagamento.QUITADO, ped1, 6));
//		ped1.setMpPagamento(pagto1);
//		ped1 = pedidoRepository.save(ped1);
		
//		MpPagamento pagto2 = pagamentoRepository.save(new MpPagamentoComBoleto(2, MpEstadoPagamento.PENDENTE, ped2, 
//																						sdf.parse("20/10/2017 00:00"), null));
//		ped2.setMpPagamento(pagto2);
//		ped2 = pedidoRepository.save(ped2);
		
//		cli1.getMpPedidos().addAll(Arrays.asList(ped1, ped2));
//		cli1 = clienteRepository.save(cli1);
//		//
//		MpItemPedido ip1 = itemPedidoRepository.save(new MpItemPedido(ped1, p1, 0.00, 1, 2000.00));
//		MpItemPedido ip2 = itemPedidoRepository.save(new MpItemPedido(ped1, p3, 0.00, 2, 80.00));
//		MpItemPedido ip3 = itemPedidoRepository.save(new MpItemPedido(ped2, p2, 100.00, 1, 800.00));
//		
//		ped1.getMpItens().addAll(Arrays.asList(ip1, ip2));
//		ped2.getMpItens().addAll(Arrays.asList(ip3));
//		
//		p1.getMpItens().addAll(Arrays.asList(ip1));
//		p2.getMpItens().addAll(Arrays.asList(ip3));
//		p3.getMpItens().addAll(Arrays.asList(ip2));
//		
//		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));		
	}

}
