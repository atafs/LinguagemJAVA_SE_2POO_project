/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 23/03/2015 
 */

package pt.iscte.poo.instalacao.enums;

public enum LinhaTomadaEstado {

	// STATUS
	/**
	 * Inserir diferentes aparelhos a tomada. FREE = posso adicionar aparelhos;
	 * BEING_USED_ONE_PLUGIN = so posso adicionar um aparelho;
	 * BEING_USED_SEVERAL_PLUGINS = posso adicionar varios aparelhos;
	 */
	FREE, BEING_USED_ONE_PLUGIN, BEING_USED_SEVERAL_PLUGINS;
}
