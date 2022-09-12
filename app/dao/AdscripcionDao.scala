package dao

import models.Adscripcion
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.PostgresProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}


class AdscripcionDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[PostgresProfile] {

  //  import profile.api._

  import slick.jdbc.PostgresProfile.api._


  private class AdscripcionTable(tag: Tag) extends Table[Adscripcion](tag, "catalogos_adscripcion") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def descripcion = column[String]("descripcion")

    def * = (id, descripcion).mapTo[Adscripcion]
  }

  private val adscripciones = TableQuery[AdscripcionTable]

  def all(): Future[Seq[Adscripcion]] = db.run(adscripciones.result)




}
