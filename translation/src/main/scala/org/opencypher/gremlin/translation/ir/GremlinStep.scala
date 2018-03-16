/*
 * Copyright (c) 2018 "Neo4j, Inc." [https://neo4j.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opencypher.gremlin.translation.ir

import org.apache.tinkerpop.gremlin.process.traversal.{Order => TraversalOrder, Scope}
import org.apache.tinkerpop.gremlin.structure.Column
import org.opencypher.gremlin.traversal.CustomFunction

sealed trait GremlinStep

case object Vertex extends GremlinStep
case class AddE(edgeLabel: String) extends GremlinStep
case object AddV extends GremlinStep
case class AddV(vertexLabel: String) extends GremlinStep
case class Aggregate(sideEffectKey: String) extends GremlinStep
case class And(andTraversals: Seq[GremlinStep]*) extends GremlinStep
case class As(stepLabel: String) extends GremlinStep
case object Barrier extends GremlinStep
case class BothE(edgeLabels: String*) extends GremlinStep
case class By(traversal: Seq[GremlinStep], order: Option[TraversalOrder]) extends GremlinStep
case class Cap(sideEffectKey: String) extends GremlinStep
case class ChooseT(
    traversalPredicate: Seq[GremlinStep],
    trueChoice: Seq[GremlinStep],
    falseChoice: Seq[GremlinStep] = Nil)
    extends GremlinStep
case class ChooseP(predicate: GremlinPredicate, trueChoice: Seq[GremlinStep], falseChoice: Seq[GremlinStep] = Nil)
    extends GremlinStep
case class Coalesce(coalesceTraversals: Seq[GremlinStep]*) extends GremlinStep
case class Constant(e: Any) extends GremlinStep
case object Count extends GremlinStep
case class CountS(scope: Scope) extends GremlinStep
case object Dedup extends GremlinStep
case object Drop extends GremlinStep
case object Emit extends GremlinStep
case object Fold extends GremlinStep
case class From(fromStepLabel: String) extends GremlinStep
case object Group extends GremlinStep
case class Has(propertyKey: String) extends GremlinStep
case class HasKey(labels: String*) extends GremlinStep
case class HasLabel(labels: String*) extends GremlinStep
case class HasNot(propertyKey: String) extends GremlinStep
case object Id extends GremlinStep
case object Identity extends GremlinStep
case class InE(edgeLabels: String*) extends GremlinStep
case object InV extends GremlinStep
case class Inject(injections: Any*) extends GremlinStep
case class Is(predicate: GremlinPredicate) extends GremlinStep
case object Key extends GremlinStep
case object Label extends GremlinStep
case class Limit(limit: Long) extends GremlinStep
case object Loops extends GremlinStep
case class MapF(function: CustomFunction) extends GremlinStep
case class MapT(traversal: Seq[GremlinStep]) extends GremlinStep
case object Max extends GremlinStep
case object Mean extends GremlinStep
case object Min extends GremlinStep
case class Not(notTraversal: Seq[GremlinStep]) extends GremlinStep
case class Or(orTraversals: Seq[GremlinStep]*) extends GremlinStep
case object Order extends GremlinStep
case object OtherV extends GremlinStep
case class OutE(edgeLabels: String*) extends GremlinStep
case object OutV extends GremlinStep
case object Path extends GremlinStep
case class Properties(propertyKeys: String*) extends GremlinStep
case class PropertyV(key: String, value: Any) extends GremlinStep
case class PropertyT(key: String, traversal: Seq[GremlinStep]) extends GremlinStep
case class Project(keys: String*) extends GremlinStep
case class Repeat(repeatTraversal: Seq[GremlinStep]) extends GremlinStep
case class SelectK(selectKeys: String*) extends GremlinStep
case class SelectC(column: Column) extends GremlinStep
case class SideEffect(sideEffectTraversal: Seq[GremlinStep]) extends GremlinStep
case class Skip(skip: Long) extends GremlinStep
case object Sum extends GremlinStep
case class Times(maxLoops: Int) extends GremlinStep
case class To(toStepLabel: String) extends GremlinStep
case object Unfold extends GremlinStep
case class Union(unionTraversals: Seq[GremlinStep]*) extends GremlinStep
case class Until(untilTraversal: Seq[GremlinStep]) extends GremlinStep
case object Value extends GremlinStep
case object ValueMap extends GremlinStep
case class Values(propertyKeys: String*) extends GremlinStep
case class WhereT(whereTraversal: Seq[GremlinStep]) extends GremlinStep
case class WhereP(predicate: GremlinPredicate) extends GremlinStep